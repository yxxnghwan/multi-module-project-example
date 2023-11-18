package com.example.batch.job

import com.example.batch.application.ExampleSaveService
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@ConditionalOnProperty(name = ["spring.batch.job.names"], havingValue = ExampleSaveJobConfig.JOB_NAME)
class ExampleSaveJobConfig(
    private val exampleSaveService: ExampleSaveService,
    private val jobRepository: JobRepository,
    private val platformTransactionManager: PlatformTransactionManager,
) {

    companion object {
        const val JOB_NAME = "saveExampleJob"
    }

    @Bean
    fun saveExampleJob(): Job {
        return JobBuilder(JOB_NAME, jobRepository)
            .incrementer(RunIdIncrementer())
            .start(saveExampleStep())
            .build()
    }

    @Bean
    @JobScope
    fun saveExampleStep(): Step {
        return StepBuilder("saveExampleStep", jobRepository)
            .tasklet(saveExampleTasklet(), platformTransactionManager)
            .build()
    }

    @Bean
    @StepScope
    fun saveExampleTasklet(): Tasklet {
        return Tasklet { contribution, chunkContext ->
            val content = exampleSaveService.save()
            println(content)
            RepeatStatus.FINISHED
        }
    }
}
