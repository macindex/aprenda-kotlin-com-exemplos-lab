// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)


enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Usuario(val nomeUsuario: String, val matriculaUsuario: String) {
    override fun toString(): String {
        return "$nomeUsuario (matrícula $matriculaUsuario)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome (Duração: $duracao)"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        //  return "Formação: $nome\nConteúdo educacional: $conteudos\nNível: $nivel\nAlunos
        return """
        Formação: $nome
        Conteúdo educacional: $conteudos
        Duração do conteúdo: 
        Nível: $nivel
        Alunos inscritos na Formação: $inscritos
        """.trimIndent()
    }
}

fun generateMatricula(): String {
    return (1000..10000).random().toString()
}

fun main() {
    val marcelo = Usuario("Marcelo", generateMatricula())
    val nycolle = Usuario("Nycolle", generateMatricula())
    val vitoria = Usuario("Vitoria", generateMatricula())
    val zane = Usuario("Zane", generateMatricula())
    val raquel = Usuario("Raquel", generateMatricula())
    val joao = Usuario("João", generateMatricula())
    val antony = Usuario("Antony generateMatricula())

    val conteudoEducacionalAngular = ConteudoEducacional("Formação Angular Developer", 36)
    val conteudoEducacionalTypeScript =
            ConteudoEducacional("Formação TypeScript Fullstack Developer", 44)
    val conteudoEducacionalReact = ConteudoEducacional("Formação React Developer", 34)
    val conteudoEducacionalJava = ConteudoEducacional("Java", 150)
    val conteudoEducacionalKotlin = ConteudoEducacional("Kotlin", 120)
    val conteudoEducacionalSpring = ConteudoEducacional("Spring Framework", 100)
    val conteudoEducacionalFlutter = ConteudoEducacional("Flutter", 90)

    val formacaoJava =
            Formacao("Java Developer", listOf(conteudoEducacionalJava), Nivel.INTERMEDIARIO)
    val formacaoReact =
            Formacao("React Developer", listOf(conteudoEducacionalReact), Nivel.INTERMEDIARIO)
    val formacaoKotlin =
            Formacao("Formação Kotlin Developer", listOf(conteudoEducacionalKotlin), Nivel.BASICO)
    val formacaoTypeScript =
            Formacao(
                    "Formação TypeScript Developer",
                    listOf(conteudoEducacionalTypeScript),
                    Nivel.INTERMEDIARIO
            )
    val formacaoSpring =
            Formacao(
                    "Spring Framework Developer",
                    listOf(conteudoEducacionalSpring),
                    Nivel.INTERMEDIARIO
            )
    val formacaoWeb =
            Formacao(
                    "Formação Web Developer",
                    listOf(
                            conteudoEducacionalAngular,
                            conteudoEducacionalTypeScript,
                            conteudoEducacionalReact
                    ),
                    Nivel.AVANCADO
            )
    val formacaoFlutter =
            Formacao("Formação Flutter Developer", listOf(conteudoEducacionalFlutter), Nivel.BASICO)

    formacaoJava.matricular(marcelo, antony)
    formacaoWeb.matricular(marcelo, vitoria, zane)
    formacaoKotlin.matricular(joao, antony)
    formacaoReact.matricular(raquel, nycolle, zane)
    formacaoTypeScript.matricular(raquel, nycolle)

    println(formacaoJava)
    println("\n**********************\n")
    println(formacaoWeb)
    println("\n**********************\n")
    println(formacaoKotlin)
    println("\n**********************\n")
    println(formacaoReact)
    println("\n**********************\n")
    println(formacaoTypeScript)
    println("\n**********************\n")
}
