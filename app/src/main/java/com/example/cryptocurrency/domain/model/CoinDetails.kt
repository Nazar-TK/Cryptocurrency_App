package com.example.cryptocurrency.domain.model
import com.example.cryptocurrency.data.remote.dto.Tag
import com.example.cryptocurrency.data.remote.dto.TeamMember


data class CoinDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val isActive: Boolean,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>
)
