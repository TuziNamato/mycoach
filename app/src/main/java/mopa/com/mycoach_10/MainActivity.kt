package mopa.com.mycoach_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var questions = ArrayList<String>().apply {
            add("Como você se imagina fazendo sua diferença e servindo com excelência no futuro?")
            add("Quais dos seus objetivos você considera os mais significativos? Quais trazem mais entusiasmo, conexão e satisfação?")
            add("Que habilidades você se imagina desenvolvendo no futuro que são essenciais para seu sucesso?")
            add("Como você se imagina socialmente no futuro?")
            add("Quais os principais sentimento que você quer sentir ao longo do dia?")
            add("Quais características você imagina que definirão você no futuro?")

            add("O que você pode fazer para se sentir no seu melhor estado possível ao longo do dia?")
            add("O que você pode fazer para se divertir mais durante suas atividades?")
            add("O que você pode fazer para dormir melhor?")
            add("O que você pode fazer para comer melhor?")

            add("O que você pode fazer para se sentir mais obcecado com sua performance?")
            add("O que você pode fazer para cumprir com seus valores e expectativas para trabalhar com mais excelência?")
            add("O que você pode fazer para identificar seu objetivo mais como uma obsessão do que como uma paixão?")
            add("Quem mais precisa que você se destaque?")
            add("Que prazos mais tornam o seu trabalho algo urgente?")
            add("O que você pode fazer para dizer em voz alta o motivo de você querer isso?")
            add("O que você pode fazer para passar mais tempo com pessoas positivas e bem sucedidas?")

            add("Quais esforços importam mais para determinar seu sucesso?")
            add("O que você pode fazer para se esforçar com um padrão maior de qualidade?")
            add("O que você pode fazer para investir menos tempo em esforços menos importantes?")
            add("Quais são os 5 objetivos que devem ser concluídos para que seu sonho se concretize?")
            add("Quais são as 5 principais skills que você precisa desenvolver para ser a pessoa que você quer ser em 3 anos?")

            add("Como a melhor versão de você lida com situações extremamentes difíceis?")
            add("O que você pode fazer para expressar mais para as pessoas ao seu redor seus verdadeiros pensamentos e sentimentos?")
            add("O que você pode fazer para expressar mais para as pessoas ao seu redor seus sonhos?")
            add("O que você pode fazer para sonhar mais alto?")
            add("Por quem você luta?")

            add("O que você quer que as pessoas pensem sobre elas mesmas?")
            add("O que você quer que as pessoas pensem sobre outras pessoas?")
            add("O que você quer que as pessoas pensem sobre o mundo como um todo?")
            add("O que você pode fazer para desafiar mais as pessoas a desenvolverem o carater delas?")
            add("O que você pode fazer para desafiar mais as pessoas a desenvolverem o nivel de conexão delas com outras pessoas?")
            add("O que você pode fazer para desafiar mais as pessoas a contribuirem com maiores níveis de excelência e distinção?")
            add("O que você pode fazer para ser um bom exemplo a ser seguido, alguém que as pessoas admiram?")
            add("O que você pode fazer para demonstrar mais reconhecimento e valorização?")
            add("O que você pode fazer para demonstrar mais paciência?")
            add("O que você pode fazer para demonstrar mais reconhecimento e valorização?")
            add("O que você pode fazer para demonstrar mais paciência?")
        }

        var habits = ArrayList<String>().apply {
            add("Clareza")
            add("Clareza")
            add("Clareza")
            add("Clareza")
            add("Clareza")
            add("Clareza")

            add("Energia")
            add("Energia")
            add("Energia")
            add("Energia")

            add("Necessidade")
            add("Necessidade")
            add("Necessidade")
            add("Necessidade")
            add("Necessidade")
            add("Necessidade")
            add("Necessidade")

            add("Produtividade")
            add("Produtividade")
            add("Produtividade")
            add("Produtividade")
            add("Produtividade")

            add("Coragem")
            add("Coragem")
            add("Coragem")
            add("Coragem")
            add("Coragem")

            add("Influência")
            add("Influência")
            add("Influência")
            add("Influência")
            add("Influência")
            add("Influência")
            add("Influência")
            add("Influência")
            add("Influência")

            add("Temp")
            add("Temp")
        }

        buttonId.setOnClickListener{
            val rand = Random().nextInt(questions.size)
            habit.text = habits[rand]
            question.text = questions[rand]
            better.text = "Como levar isso para o próximo nível?"
        }
    }
}
