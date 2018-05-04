# MaoNaMassaBasica1

### Primeira Aula

    - Iniciamos o projeto com hello world.
    - Mostramos o LinearLayout: horizontal e vertical.    
    - Explicamos que todas as views possuem tamanho e posição.
    - Conceito de <tag></tag> dentro dos arquivos de views.
    - Activity é onde programamos o comportamento da view. Interação do usuário com o celular.
    - Views precisam de ids para serem referenciadas na Activity.
    - Fizemos o botão ser apertado e mudar o texto.
    
``` MainActivity.kt
class MainActivity : AppCompatActivity() {

    /*
    *
    * LifeCycle da Activity: onPause, onResume, onCreate
    *
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botaoVermelho.setOnClickListener({
            click()
        })
    }

    /*
    *
    * Um método possui o seguinte formato
    *
    * fun nomeDoMetodo(parametros: tipo ou simplesmente vazio) {
    *   // instruções de código que podem ser invocados a qualquer instante dentro dessa Activity
    * }
    *
    * */

    fun click() {
        textoClicou.text = "O botão foi clicado"
    }

}
```
    
```activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <!--

    Dentro do arquivo XML só podemos escrever no formato de tags
    <tag
        android:id="@+id/{idDesejado}"
        android:layout_width="match_parent"
        android:layout_height="320dp"
        outros_attributos="valor"
    ></tag>
        ou
    <tag
        android:id="@+id/{idDesejado}"
        android:layout_width="match_parent"
        android:layout_height="320dp"
        outros_attributos="valor"
    />

    Algumas tags ou views podem ter outras tags dentro dele, portanto
    é preciso utilizar o primeiro formato. Ex. LinearLayout

    -->

    <Button
        android:id="@+id/botaoVermelho"
        android:layout_width="match_parent"
        android:layout_height="320dp"
        android:background="#fff000"
        android:text="Click em mim"/>

    <TextView
        android:id="@+id/textoClicou"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CLICOU???"/>

</LinearLayout>
```
### Segunda Aula

    - Foi criado um Layout com 3 botões na horizontal em um layout vertical.
    - Estrutura de layouts mais complexos com templates.
    - Dinamica das frutas e pessoas.
    - Botão que indica qual a fruta que foi comida.
    - Texto indicando que comida foi selecionada.
    
### Terceira Aula

### Quarta Aula

### Quinta Aula
    
