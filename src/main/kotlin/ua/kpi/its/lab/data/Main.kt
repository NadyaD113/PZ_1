package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.Hospital
import ua.kpi.its.lab.data.entity.Medicine
import ua.kpi.its.lab.data.svc.impl.HospitalServiceImpl
import ua.kpi.its.lab.data.svc.impl.MedicineServiceImpl
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab.data")
    val hospitalService = context.getBean(HospitalServiceImpl::class.java)
    val medicineService = context.getBean(MedicineServiceImpl::class.java)

    // Создаем 5 больниц и дополнительные лекарства
    val hospital1 = Hospital(
        name = "Central Hospital",
        address = "123 Main St.",
        profile = "General",
        openingDate = Date(2000, 1, 1),
        departmentCount = 10,
        bedCount = 500,
        hasChildrenDepartment = true
    )
    val hospital2 = Hospital(
        name = "City Hospital",
        address = "456 Oak St.",
        profile = "Specialized",
        openingDate = Date(2005, 5, 15),
        departmentCount = 8,
        bedCount = 300,
        hasChildrenDepartment = false
    )
    val hospital3 = Hospital(
        name = "Regional Hospital",
        address = "789 Pine St.",
        profile = "General",
        openingDate = Date(1990, 10, 1),
        departmentCount = 12,
        bedCount = 700,
        hasChildrenDepartment = true
    )
    val hospital4 = Hospital(
        name = "Private Clinic",
        address = "321 Elm St.",
        profile = "Specialized",
        openingDate = Date(2010, 3, 20),
        departmentCount = 5,
        bedCount = 150,
        hasChildrenDepartment = false
    )
    val hospital5 = Hospital(
        name = "University Hospital",
        address = "567 Maple St.",
        profile = "Research",
        openingDate = Date(1980, 9, 15),
        departmentCount = 15,
        bedCount = 800,
        hasChildrenDepartment = true
    )
    hospitalService.create(hospital1)
    hospitalService.create(hospital2)
    hospitalService.create(hospital3)
    hospitalService.create(hospital4)
    hospitalService.create(hospital5)

    val medicine1 = Medicine(
        name = "Aspirin",
        form = "Tablet",
        manufacturer = "Bayer",
        manufacturingDate = Date(2023, 1, 1),
        shelfLife = 365,
        price = 5.99,
        requiresPrescription = false,
        hospital = hospital1
    )

    val medicine2 = Medicine(
        name = "Amoxicillin",
        form = "Capsule",
        manufacturer = "GlaxoSmithKline",
        manufacturingDate = Date(2023, 2, 15),
        shelfLife = 730,
        price = 12.99,
        requiresPrescription = true,
        hospital = hospital2
    )

    medicineService.create(medicine1)
    medicineService.create(medicine2)

    println("Retrieved hospital: $hospital3")

    // Удаляем больницу с индексом 4
    hospitalService.delete(4)
}
