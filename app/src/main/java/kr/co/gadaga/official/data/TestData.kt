package kr.co.gadaga.official.data

import kr.co.gadaga.official.data.model.Category
import kr.co.gadaga.official.data.model.Store

object TestData {
    private val store1 = Store("북촌손만두", 37.533121, 127.006535, Category("분식"))
    private val store2 = Store("오스테리아 오르조", 37.534921, 127.009476, Category("양식"))
    private val store3 = Store("김가네 한남점", 37.532959, 127.006441, Category("한식"))
    private val store4 = Store("한와담", 37.533813, 127.007752, Category("한식"))
    private val store5 = Store("김종용 누룽지 통닭", 37.532761, 127.005953, Category("치킨"))

    val stores = listOf(store1, store2, store3, store4, store5)
}