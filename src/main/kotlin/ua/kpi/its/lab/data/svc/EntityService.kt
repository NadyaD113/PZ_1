package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Hospital
import ua.kpi.its.lab.data.entity.Medicine

interface HospitalService {
    fun create(hospital: Hospital): Hospital
    fun retrieve(id: Long): Hospital?
    fun update(hospital: Hospital): Hospital
    fun delete(id: Long)
}

interface MedicineService {
    fun create(medicine: Medicine): Medicine
    fun retrieve(id: Long): Medicine?
    fun update(medicine: Medicine): Medicine
    fun delete(id: Long)
}