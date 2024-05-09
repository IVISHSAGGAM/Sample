// The example of protected key word for variable and function

class Language {
    protected String name

    protected void setName(String newName) {
        this.name = newName
    }

    protected String getName() {
        return this.name
    }

    public void msg_fn(){
        println "This is public msg_fn function in Language class."
    }

    private void lang_msg_fn(){
        println "This is private lang_msg_fn function in Language class."
    }
}

class GroovyLanguage extends Language {

    GroovyLanguage() {
        setName("Groovy")
    }

    void displayLanguage() {
        println "Language name: ${getName()}"
    }
}

new Language().msg_fn()
new Language().lang_msg_fn()
new GroovyLanguage().displayLanguage()
new GroovyLanguage().msg_fn()

/* If you have a private function named lang_msg_fn() in a class called Language, \
it means that this function is meant to be used only within the Language class itself. \
You cannot call this private function from outside the Language class, 
including from any class that extends Language, such as GroovyLanguage class. */

//new GroovyLanguage().lang_msg_fn()