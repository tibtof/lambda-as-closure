package ro.tibtof.lambda.closure

class AGroovyClass {

    def useClosure(closure) {
        println 'Calling closure'
        closure()
    }

    def passToClosure(int value, closure) {
        println "Simply passing $value to the given closure"
        closure(value)
    }

    String useTypedClosure(Closure<String> closure) {
        println 'Calling closure'
        closure()
    }

    def twoParamsClosure(param1, param2, closure) {
        closure(param1, param2)
    }

    String threeParamsClosure(param1, param2, param3, closure) {
        closure(param1, param2, param3)
    }
}
