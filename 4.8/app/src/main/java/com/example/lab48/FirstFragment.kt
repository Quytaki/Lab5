package com.example.lab48

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.NavDirections
import com.example.lab48.FirstFragmentDirections

class FirstFragment : Fragment(R.layout.fragment_first) {
    private val products = listOf("Product 1", "Product 2", "Product 3", "Product 4")
    private val cart = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProductAdapter(products) { product ->
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Add to Cart")
                .setMessage("Do you want to add $product to your cart?")
                .setPositiveButton("Yes") { dialog, _ ->
                    cart.add(product)
                    Snackbar.make(view, "$product added to cart", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("No", null)
                .show()
        }

        view.findViewById<Button>(R.id.buttonViewCart).setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(cart.toTypedArray())
            findNavController().navigate(action)
        }
    }
}
