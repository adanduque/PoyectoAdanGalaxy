package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Programming;
import com.example.galaxyproyecto.repository.IProgrammingRepository;
import com.example.galaxyproyecto.service.IProgrammingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.galaxyproyecto.util.QueryUtil.getLike;

@Service
public class ProgrammingServiceImpl implements IProgrammingService {
    @Autowired
    private IProgrammingRepository programmingRepository;

    @Override
    public List<Programming> findAll() {

        //return ProgrammingRepository.findAll();
        return programmingRepository.findAllCustom();
    }

    @Override
    public Programming add(Programming teacher) {

        return programmingRepository.save(teacher);
    }

    @Override
    public Optional<Programming> findById(Integer id) {

        return programmingRepository.findById(id);
    }

    @Override
    public Programming update(Programming teacher) {

        Optional<Programming> optProgramming = programmingRepository.findById(teacher.getIdProgramming());

        if (optProgramming.isPresent()) {
            Programming retProgramming = optProgramming.get();
            BeanUtils.copyProperties(teacher, retProgramming);
            return programmingRepository.save(retProgramming);
        }
        return null;
    }

    @Override
    public Programming delete(Integer id) {
        Optional<Programming> optProgramming = programmingRepository.findById(id);

        if (optProgramming.isPresent()) {
            Programming retProgramming = optProgramming.get();
            retProgramming.setState(0);
            return programmingRepository.save(retProgramming);
        }
        return null;
    }


}
