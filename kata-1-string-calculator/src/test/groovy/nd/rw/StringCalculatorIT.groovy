package nd.rw

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class StringCalculatorIT extends Specification {

    @Subject
    private StringCalculator stringCalculator = new StringCalculator()

    def "should return 0 for null, empty, empty string"() {
        expect:
            stringCalculator.add(null) == 0
            stringCalculator.add("") == 0
            stringCalculator.add("   ") == 0
    }

    def "should return #value for string with only #value"() {
        expect:
            stringCalculator.add("$value") == value

        where:
            value << (1..10).toArray()
    }

    def "should return 3 for string [1,2]"() {
        expect:
            stringCalculator.add('1,2') == 3
    }

    def "should return 25 for [5,5,5,5,5]"() {
        expect:
            stringCalculator.add("5,5,5,5,5") == 25
    }

    def "should return 6 for [1\\n2,3]"() {
        expect:
            stringCalculator.add("1\n2,3") == 6
    }

    @Unroll
    def "should return 6 for [//#delimiter\\n 1 #delimiter 2 #delimiter 3] specifying custom delimiter '#delimiter'"() {
        expect:
            stringCalculator.add("//${delimiter}\n1${delimiter}2${delimiter}3")
        where:
            delimiter << [";", ",", " "]
    }

    def "should throw NegativeNotAllowedException if negative is supplied"() {
        when:
            stringCalculator.add("-1")
        then:
            def e = thrown IllegalArgumentException
            e.message == "Negatives not allowed -1"
    }

    def "should return 2 for [2,1001] numbers bigger than 1000 should be ignored"() {
        expect:
            stringCalculator.add("2,1001") == 2
    }

    def "should return 1002 for [2,1000] numbers bigger than 10002 should be ignored"() {
        expect:
            stringCalculator.add("2,1000") == 1002
    }

}
