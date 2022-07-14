package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Schedule;
import com.example.galaxyproyecto.repository.IScheduleRepository;
import com.example.galaxyproyecto.service.IScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAll() {

        //return ScheduleRepository.findAll();
        return scheduleRepository.findAllCustom();
    }

    @Override
    public Schedule add(Schedule schedule) {

        return scheduleRepository.save(schedule);
    }

    @Override
    public Optional<Schedule> findById(Integer id) {

        return scheduleRepository.findById(id);
    }

    @Override
    public Schedule update(Schedule schedule) {

        Optional<Schedule> optSchedule = scheduleRepository.findById(schedule.getIdSchedule());

        if (optSchedule.isPresent()) {
            Schedule retSchedule = optSchedule.get();
            BeanUtils.copyProperties(schedule, retSchedule);
            return scheduleRepository.save(retSchedule);
        }
        return null;
    }

    @Override
    public Schedule delete(Integer id) {
        Optional<Schedule> optSchedule = scheduleRepository.findById(id);

        if (optSchedule.isPresent()) {
            Schedule retSchedule = optSchedule.get();
            retSchedule.setState(0);
            return scheduleRepository.save(retSchedule);
        }
        return null;
    }


}
