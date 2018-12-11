package slawomir.kustra.kodeinexample.domain

import io.reactivex.Scheduler

interface PostExecutionThread {

        val scheduler: Scheduler
}