package com.example.helper.presentation.task

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.helper.R
import com.example.helper.databinding.ActivityTaskBinding
import com.example.helper.domain.model.ShopItem
import com.example.helper.extentions.showToastShort
import com.example.helper.presentation.main.MainViewModel
import com.example.helper.presentation.shopItemAdapter.ShopItemAdapter

class TaskActivity : AppCompatActivity(R.layout.activity_task) {

    private val binding by viewBinding(ActivityTaskBinding::bind, R.id.task_container)
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopItemAdapter
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLauncher()
        initViewModel()
        initRecyclerView()
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun initListeners() {
        adapter.onShopItemClickListener = {
            viewModel.deleteShopItem(it)
        }
        adapter.onShopItemLongClickListener = {
            viewModel.editShopItem(it)
            showToastShort("Изменено состояние объекта ${it.enabled}")
        }
        binding.fab.setOnClickListener {
            val intent = Intent(this@TaskActivity, SecondTaskActivity::class.java)
            launcher.launch(intent)
        }
    }

    private fun initRecyclerView() {
        adapter = ShopItemAdapter()
        binding.taskRecycler.adapter = adapter
        setUpSwipeListener()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val userText = it.data?.getStringExtra(USER_KEY)
                val userText2 = it.data?.getStringExtra(USER_KEY2)
                if (userText != null ) {
                    if (userText2 != null) {
                        viewModel.addShopItem(ShopItem(userText, userText2.toInt(), enabled = false))
                    }
                }
            }
        }
    }

    private fun setUpSwipeListener() {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.currentList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.taskRecycler)
    }

    companion object {
        const val USER_KEY = "User"
        const val USER_KEY2 = "User2"
    }
}