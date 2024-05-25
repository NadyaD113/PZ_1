package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class Hospital(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val address: String,
    val profile: String,
    val openingDate: Date,
    val departmentCount: Int,
    val bedCount: Int,
    val hasChildrenDepartment: Boolean,

    @OneToMany(mappedBy = "hospital", cascade = [CascadeType.ALL], orphanRemoval = true)
    val medicines: MutableList<Medicine> = mutableListOf()
) : Comparable<Hospital> {
    override fun compareTo(other: Hospital): Int {
        val nameComparison = name.compareTo(other.name)
        return if (nameComparison != 0) nameComparison else id.compareTo(other.id)
    }
}

@Entity
data class Medicine(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val form: String,
    val manufacturer: String,
    val manufacturingDate: Date,
    val shelfLife: Int, // в днях
    val price: Double,
    val requiresPrescription: Boolean,

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital
) : Comparable<Medicine> {
    override fun compareTo(other: Medicine): Int {
        val nameComparison = name.compareTo(other.name)
        return if (nameComparison != 0) nameComparison else id.compareTo(other.id)
    }
}
