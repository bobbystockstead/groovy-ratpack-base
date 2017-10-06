import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class HelloWorldSpec extends Specification {

    @AutoCleanup
    @Shared
    GroovyRatpackMainApplicationUnderTest systemUnderTest = new GroovyRatpackMainApplicationUnderTest()

    def 'Should render \'Hello, World!\''() {
        expect:
            systemUnderTest.httpClient.text == 'Hello, World!'
    }
}
