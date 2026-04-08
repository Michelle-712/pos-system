package com.example.possystem.ui.theme.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.possystem.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavHostController){
    var selectedItem by remember { mutableIntStateOf(0)}
    Scaffold (
        topBar = { TopAppBar(
            title = { Text(
                text = "POS Dashboard",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Cyan,
                titleContentColor = Color.Black,),
            actions = {
                IconButton(onClick = {
                    navController.navigate(ROUTE_LOGIN){
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
                }
            }
        ) },
        bottomBar = { NavigationBar(containerColor = Color.Cyan) {
            NavigationBarItem(
                selected = selectedItem == 0,
                onClick = { selectedItem = 0 },
                icon = { Icon(Icons.Default.Home, null) },
                label = { Text("Home") }
            )
            NavigationBarItem(
                selected = selectedItem == 1,
                onClick = { selectedItem = 1 },
                icon = { Icon(Icons.Default.Settings, null) },
                label = { Text("Settings") }
            )

            NavigationBarItem(
                selected = selectedItem == 2,
                onClick = { selectedItem = 2 },
                icon = { Icon(Icons.Default.Person, null) },
                label = { Text("Profile") }
            )
        } }
    )
    {padding ->
        Column (modifier = Modifier
            .padding(padding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
        ){
            Text(text = "Business Overview",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            
            Spacer(modifier = Modifier.height(16.dp))
            

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Today's Revenue", color = Color.Black)
                    Text(
                        "KES 12,500",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Transactions: 45", color = Color.Black)
                        Text("Profit: KES 4,200", color = Color.Black, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))


            Text(text = "Weekly Sales Trend", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier.fillMaxWidth().height(150.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {

                    Box(modifier = Modifier.width(20.dp).height(60.dp).background(Color.Cyan, RoundedCornerShape(4.dp)))
                    Box(modifier = Modifier.width(20.dp).height(100.dp).background(Color.Cyan, RoundedCornerShape(4.dp)))
                    Box(modifier = Modifier.width(20.dp).height(80.dp).background(Color.Cyan, RoundedCornerShape(4.dp)))
                    Box(modifier = Modifier.width(20.dp).height(120.dp).background(Color.Cyan, RoundedCornerShape(4.dp)))
                    Box(modifier = Modifier.width(20.dp).height(90.dp).background(Color.Cyan, RoundedCornerShape(4.dp)))
                    Box(modifier = Modifier.width(20.dp).height(110.dp).background(Color.Cyan, RoundedCornerShape(4.dp)))
                    Box(modifier = Modifier.width(20.dp).height(130.dp).background(Color.Blue, RoundedCornerShape(4.dp)))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(text = "Inventory Status", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                InventoryItemCard("Total Items", "1,580", Modifier.weight(1f))
                InventoryItemCard("Low Stock", "15", Modifier.weight(1f), isAlert = true)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier.weight(1f).height(120.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "New Products", fontWeight = FontWeight.Bold)
                    }
                }

                Card(
                    modifier = Modifier.weight(1f).height(120.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Products", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun InventoryItemCard(label: String, value: String, modifier: Modifier = Modifier, isAlert: Boolean = false) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = if (isAlert) Color(0xFFFFEBEE) else Color(0xFFE0F7FA))
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, fontSize = 14.sp, color = Color.DarkGray)
            Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (isAlert) Color.Red else Color.Black)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview(){
    Dashboard(rememberNavController())
}