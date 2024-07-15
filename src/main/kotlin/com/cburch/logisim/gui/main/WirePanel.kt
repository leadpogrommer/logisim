package com.cburch.logisim.gui.main

import com.cburch.logisim.circuit.Circuit
import com.cburch.logisim.comp.Component
import com.cburch.logisim.data.Location
import com.cburch.logisim.proj.Project
import java.awt.Point
import java.awt.Rectangle
import java.lang.Integer.max
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel



data class NetCompModel(val name: String, val loc: Location, val comp: Component)
data class WireNetModel(val tunnels: List<NetCompModel>, val drivers: List<NetCompModel>, val listeners: List<NetCompModel>, val mixed: List<NetCompModel>,  val c: Circuit)


class WirePanel(val f: Frame): JPanel() {
    init {
//        setLayout()
    }

    fun setLayout(model: WireNetModel){
        removeAll()
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val closeButton = JButton("Fuck it!")
        closeButton.text = "Fuck it!"
        closeButton.addActionListener { e ->
            f.closeNetPane()
        }
        add(closeButton)

        addHeader("Tunnels")
        addComps(model, model.tunnels)
        addHeader("Drivers")
        addComps(model, model.drivers)
        addHeader("Listeners")
        addComps(model, model.listeners)
        addHeader("Mixed")
        addComps(model, model.mixed)

        revalidate()
        repaint()

//        closeButton.isEnabled = true
//        closeButton.setSize(100, 100)
//        for(i in 0 until 100){
//            add(JLabel("fuck $i"))
//        }
//        closeButton.revalidate()
//        closeButton.repaint()
//        revalidate()
//        repaint()
    }

    fun addHeader(s: String){
        val l = JLabel(s)
        l.font = l.font.deriveFont(20);
        add(l)
    }

    fun addComps(model: WireNetModel, cc: List<NetCompModel>){
        for (c in cc){
            val b = JButton(c.name)
            b.addActionListener { e ->
                println("Clicked on ${c.name} at {${c.loc}}")
                f.canvas.setHaloedComponent(model.c, c.comp)
                val nx = (c.loc.x * f.canvas.zoomFactor).toInt()
                val ny = (c.loc.y * f.canvas.zoomFactor).toInt()
                println("${c.loc.x} ${c.loc.y} $nx $ny")
                val border = (50 * f.canvas.zoomFactor).toInt()

                f.canvas.viewport.viewPosition = Point(max(nx - f.canvas.viewport.width/2, 0), max(ny - f.canvas.viewport.height/2, 0))
//                f.canvas.viewport.scrollRectToVisible(Rectangle(max(nx-border, 0), max(ny-border, 0), border*2, border*2))
            }
            add(b)
        }
    }
}