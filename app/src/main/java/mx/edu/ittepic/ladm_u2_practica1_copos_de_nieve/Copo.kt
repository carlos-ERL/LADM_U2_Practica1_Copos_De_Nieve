package mx.edu.ittepic.ladm_u2_practica1_copos_de_nieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo(l:Lienzo) {
    val l=l
    var x=0f
    var y=0f
    var movX = 0f
    var movY = 0f
    var tam = 0f
    var color = Color.RED

    //Asi se manda llamar un constructor
    init {
        x=rand(1600)
        y= rand(1900)
        tam = ((Math.random()*10)+3).toFloat()
    }

    private fun rand(hasta:Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }
    fun moverCopo() {
        y += ((Math.random()*3)+5).toFloat()
        if(y>2500) y= ((Math.random()*2800)*-1).toFloat()
    }

    fun pintar(c: Canvas) {
        val p = Paint()
        p.color = Color.WHITE
        c.drawCircle(x,y,tam,p)
    }

}