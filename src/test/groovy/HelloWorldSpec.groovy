import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class HelloWorldSpec extends Specification {

    @AutoCleanup
    @Shared
    GroovyRatpackMainApplicationUnderTest systemUnderTest = new GroovyRatpackMainApplicationUnderTest()

    def 'Should render \'Hello, World!\''() {
        expect:
            systemUnderTest.httpClient.text == 'Hello, World!'
    }

    @Unroll
    def 'Should render \'Hello, #output!\''() {
        expect:
            systemUnderTest.httpClient.getText(path) == "Hello, $output!"

        where:
            path                |   output
            'Bobby'             |   'Bobby'
            'Stockstead'        |   'Stockstead'
            'Bobby%20Stockstead'  |   'Bobby Stockstead'
    }
}
