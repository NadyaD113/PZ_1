package ua.kpi.its.lab.data.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Hospital
import ua.kpi.its.lab.data.entity.Medicine
import ua.kpi.its.lab.data.repo.HospitalRepository
import ua.kpi.its.lab.data.repo.MedicineRepository
import ua.kpi.its.lab.data.svc.HospitalService
import ua.kpi.its.lab.data.svc.MedicineService

@Service
class HospitalServiceImpl(private val repo: HospitalRepository) : HospitalService {
    override fun create(hospital: Hospital) = repo.save(hospital)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(hospital: Hospital) = repo.save(hospital)
    override fun delete(id: Long) = repo.deleteById(id)
}

@Service
class MedicineServiceImpl(private val repo: MedicineRepository) : MedicineService {
    override fun create(medicine: Medicine) = repo.save(medicine)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(medicine: Medicine) = repo.save(medicine)
    override fun delete(id: Long) = repo.deleteById(id)
}
