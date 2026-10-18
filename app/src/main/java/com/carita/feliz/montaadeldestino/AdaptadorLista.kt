package com.carita.feliz.montaadeldestino

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class MiAdaptador(private val context: Context, private val listaObjetos: List<Territorio>) : BaseAdapter() {

    override fun getCount(): Int = listaObjetos.size

    override fun getItem(position: Int): Any = listaObjetos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false)

        val imgElemento = vista.findViewById<ImageView>(R.id.imgElemento)
        val txtTitulo = vista.findViewById<TextView>(R.id.txtTitulo)
        val txtDescripcion = vista.findViewById<TextView>(R.id.txtDescripcion)

        val itemActual = listaObjetos[position]

        imgElemento.setImageResource(itemActual.imagenId)
        txtTitulo.text = itemActual.nombre
        txtDescripcion.text = itemActual.descripcion

        return vista
    }
}