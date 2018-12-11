package slawomir.kustra.kodeinexample.domain

abstract class UseCase<in Params, out ReturnType> where ReturnType : Any {

    abstract fun execute(params : Params) : ReturnType
git commit
}