package mx.edu.ittepic.ladm_u2_practica1_copos_de_nieve

import android.graphics.*
import android.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

class Lienzo (este:MainActivity): View(este) {
    val este = este
    var fogata = BitmapFactory.decodeResource(este.resources, R.drawable.fogata)
    val copos = Array<Copo>(500,{ Copo(this) })
    var brisa = 30
    var lluvia_fuerte = 200
    var contador = 0

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    val lluvia = scope.launch(EmptyCoroutineContext, CoroutineStart.LAZY) {
        while (true) {
            (0..copos.size-1).forEach {
                copos[it].moverCopo()
            }
            contador++
            este.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        //Paint
        var p = Paint()
        val ancho = width.toFloat()
        val alto = height.toFloat()
        val limiteMontañas = 1500f
        var color = Color.rgb(15, 18, 54)
        c.drawColor(color)
        //Montañas
        p.color = Color.LTGRAY
        c.drawOval(-100f, limiteMontañas + 2100, 1800f, 1500f, p)
        c.drawOval(-100f, limiteMontañas + 800, 800f, 1000f, p)
        //Casa
        color = Color.rgb(50, 158, 28)
        p.color = color
        c.drawRect(570f, limiteMontañas - 300f, 990f, limiteMontañas, p)
        color = Color.rgb(0, 162, 232)
        p.color = color
        c.drawRect(850f, limiteMontañas - 230f, 950f, limiteMontañas - 130f, p)
        p.color = Color.rgb(112, 89, 3)
        c.drawRect(600f, limiteMontañas - 230f, 740f, limiteMontañas, p)
        //Cuadro de la chimenea
        color = Color.rgb(232, 117, 5)
        p.color = color
        c.drawRect(880f, limiteMontañas - 500f, 970f, limiteMontañas - 350f, p)

        //Triangulo de Techo
        val pa = Point(540, limiteMontañas.toInt() - 310)
        val pb = Point(1040, limiteMontañas.toInt() - 310)
        val pc = Point(790, limiteMontañas.toInt() - 560)

        val path = Path()
        path.setFillType(Path.FillType.EVEN_ODD)
        path.moveTo(pb.x.toFloat(), pb.y.toFloat())
        path.lineTo(pb.x.toFloat(), pb.y.toFloat())
        path.lineTo(pc.x.toFloat(), pc.y.toFloat())
        path.lineTo(pa.x.toFloat(), pa.y.toFloat())
        path.close()
        c.drawPath(path, p)

        //Tronco de los arboles
        color = Color.rgb(136, 0, 21)
        p.color = color
        c.drawRect(50f, limiteMontañas - 400f, 100f, limiteMontañas, p)
        c.drawRect(ancho - 730f, limiteMontañas - 300f, ancho - 670f, limiteMontañas, p)
        //Hojas arboles
        //PRIMER ARBOL, ARBOL LIMITE
        //Triangulo hasta abajo arbol limite
        val paH1 = Point(10, limiteMontañas.toInt() - 310)
        val pbH1 = Point(150, limiteMontañas.toInt() - 310)
        val pcH1 = Point(80, limiteMontañas.toInt() - 460)
        val path2 = Path()
        color = Color.rgb(25, 84, 25)
        p.color = color
        path2.setFillType(Path.FillType.EVEN_ODD)
        path2.moveTo(pbH1.x.toFloat(), pbH1.y.toFloat())
        path2.lineTo(pbH1.x.toFloat(), pbH1.y.toFloat())
        path2.lineTo(pcH1.x.toFloat(), pcH1.y.toFloat())
        path2.lineTo(paH1.x.toFloat(), paH1.y.toFloat())
        path2.close()
        c.drawPath(path2, p)
        //Triangulo mitad arbol limite
        val paH2 = Point(10, limiteMontañas.toInt() - 380)
        val pbH2 = Point(150, limiteMontañas.toInt() - 380)
        val pcH2 = Point(80, limiteMontañas.toInt() - 500)
        val path3 = Path()
        color = Color.rgb(37, 125, 37)
        p.color = color
        path3.setFillType(Path.FillType.EVEN_ODD)
        path3.moveTo(pbH2.x.toFloat(), pbH2.y.toFloat())
        path3.lineTo(pbH2.x.toFloat(), pbH2.y.toFloat())
        path3.lineTo(pcH2.x.toFloat(), pcH2.y.toFloat())
        path3.lineTo(paH2.x.toFloat(), paH2.y.toFloat())
        path3.close()
        c.drawPath(path3, p)
        //Triangulo de hasta arriba arbol limite
        val paH3 = Point(10, limiteMontañas.toInt() - 450)
        val pbH3 = Point(150, limiteMontañas.toInt() - 450)
        val pcH3 = Point(80, limiteMontañas.toInt() - 560)
        val path4 = Path()
        color = Color.WHITE
        p.color = color
        path4.setFillType(Path.FillType.EVEN_ODD)
        path4.moveTo(pbH3.x.toFloat(), pbH3.y.toFloat())
        path4.lineTo(pbH3.x.toFloat(), pbH3.y.toFloat())
        path4.lineTo(pcH3.x.toFloat(), pcH3.y.toFloat())
        path4.lineTo(paH3.x.toFloat(), paH3.y.toFloat())
        path4.close()
        c.drawPath(path4, p)
        //SEGUNDO ARBOL
        //Triangulo hasta abajo segundo arbol
        val paH4 = Point(300, limiteMontañas.toInt() - 310)
        val pbH4 = Point(470, limiteMontañas.toInt() - 310)
        val pcH4 = Point(380, limiteMontañas.toInt() - 420)
        val path5 = Path()
        color = Color.rgb(25, 84, 25)
        p.color = color
        path5.setFillType(Path.FillType.EVEN_ODD)
        path5.moveTo(pbH4.x.toFloat(), pbH4.y.toFloat())
        path5.lineTo(pbH4.x.toFloat(), pbH4.y.toFloat())
        path5.lineTo(pcH4.x.toFloat(), pcH4.y.toFloat())
        path5.lineTo(paH4.x.toFloat(), paH4.y.toFloat())
        path5.close()
        c.drawPath(path5, p)
        //Triangulo mitad segundo arbol
        val paH5 = Point(300, limiteMontañas.toInt() - 380)
        val pbH5 = Point(470, limiteMontañas.toInt() - 380)
        val pcH5 = Point(380, limiteMontañas.toInt() - 480)
        val path6 = Path()
        color = Color.rgb(37, 125, 37)
        p.color = color
        path6.setFillType(Path.FillType.EVEN_ODD)
        path6.moveTo(pbH5.x.toFloat(), pbH5.y.toFloat())
        path6.lineTo(pbH5.x.toFloat(), pbH5.y.toFloat())
        path6.lineTo(pcH5.x.toFloat(), pcH5.y.toFloat())
        path6.lineTo(paH5.x.toFloat(), paH5.y.toFloat())
        path6.close()
        c.drawPath(path6, p)
        //Triangulo hasta arriba segundo arbol
        val paH6 = Point(300, limiteMontañas.toInt() - 450)
        val pbH6 = Point(470, limiteMontañas.toInt() - 450)
        val pcH6 = Point(380, limiteMontañas.toInt() - 530)
        val path7 = Path()
        color = Color.WHITE
        p.color = color
        path7.setFillType(Path.FillType.EVEN_ODD)
        path7.moveTo(pbH6.x.toFloat(), pbH6.y.toFloat())
        path7.lineTo(pbH6.x.toFloat(), pbH6.y.toFloat())
        path7.lineTo(pcH6.x.toFloat(), pcH6.y.toFloat())
        path7.lineTo(paH6.x.toFloat(), paH6.y.toFloat())
        path7.close()
        c.drawPath(path7, p)
        //Circulos del humo
        p.color = Color.WHITE
        c.drawOval(1010f, limiteMontañas - 750f, 850f, limiteMontañas - 690f, p)
        c.drawOval(900f, limiteMontañas - 570f, 810f, limiteMontañas - 610f, p)
        c.drawBitmap(fogata, (width / 2 - 380).toFloat(), (height - 520).toFloat(), p)

        //Luna
        p.color = Color.WHITE
        c.drawCircle(300f,100f,100f,p)
        p.color = Color.rgb(15, 18, 54)
        c.drawCircle(260f,130f,80f,p)

        lluvia.start()

        iniciarLluvia(c)

    }
    fun iniciarLluvia(c:Canvas) {
        if (contador >= 0 && contador < 300) {

            (0..brisa).forEach {
                copos[it].moverCopo()
                copos[it].pintar(c)
            }
        }
        if (contador > 300 && contador < 600) {
            (0..lluvia_fuerte).forEach {
                copos[it].moverCopo()
                copos[it].pintar(c)
            }
        }
        if (contador > 600 && contador < 1100) {
            (0..copos.size-1).forEach {
                copos[it].moverCopo()
                copos[it].pintar(c)
            }
        }
        if (contador == 1100){
            contador = 1
        }
    }
}