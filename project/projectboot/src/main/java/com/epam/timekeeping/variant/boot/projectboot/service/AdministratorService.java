package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Administrator;
import com.epam.timekeeping.variant.boot.projectboot.dto.administrator.AdministratorDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.administrator.AdministratorPostDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserLogin;
import com.epam.timekeeping.variant.boot.projectboot.dto.administrator.AdministratorDto;
import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorLoginIncorrect;
import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.repository.AdministratorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ModelMapper mapper;

    public AdministratorDto getAdministratorById(Integer id) throws AdministratorNotFound
    {
        return  mapper.map(administratorRepository.findById(id).orElseThrow(()->new CategoryNotFound(id)),AdministratorDto.class);
    }
    public List<AdministratorDto> getAdministrators(){
        List<AdministratorDto> administrators = new ArrayList<>();
        administratorRepository.findAll().forEach(a->administrators.add(mapper.map(a,AdministratorDto.class)));
        return administrators;
    }

    public AdministratorDto login(UserLogin login)throws AdministratorLoginIncorrect {
        return mapper.map(administratorRepository.findByUsernameAndPassword(login.getUsername(),login.getPassword()).orElseThrow(()->new AdministratorLoginIncorrect()),AdministratorDto.class);
    }

    public AdministratorDto createAdministrator(AdministratorPostDto administrator)throws AdministratorIncorrectFormat {
        List<String> errors= new ArrayList<>();
        if(administrator.getUsername()==null||administrator.getUsername().trim().length()==0) errors.add("Empty administrator name");
        if(administratorRepository.existsByUsernameIgnoreCase(administrator.getUsername())) errors.add("Existing administratorname");
        if(administrator.getMail()==null || administrator.getMail().trim().length()==0) errors.add("Empty mail");
        if(administratorRepository.existsByMailIgnoreCase(administrator.getMail())) errors.add("Existing mail");

        if(errors.size()>0) throw new AdministratorIncorrectFormat(errors);

        return mapper.map(administratorRepository.save(mapper.map(administrator, Administrator.class)),AdministratorDto.class);
    }
    public AdministratorDto updateAdministrator(AdministratorPostDto administrator, Integer id)throws AdministratorNotFound {
        Administrator entity = administratorRepository.findById(id).orElseThrow(()->new AdministratorNotFound(id));
        entity.setMail((administrator.getMail()==null)?entity.getMail():administrator.getMail());
        entity.setName((administrator.getName()==null)?entity.getName():administrator.getName());
        entity.setUsername((administrator.getUsername()==null)?entity.getUsername():administrator.getUsername());
        entity.setPassword((administrator.getPassword()==null)?entity.getPassword():administrator.getPassword());
        entity.setRole((administrator.getRole()==null)?entity.getRole():administrator.getRole());
        return mapper.map(administratorRepository.save(entity),AdministratorDto.class);
    }
    public AdministratorDto deleteAdministrator(Integer id){
        Administrator administrator = administratorRepository.findById(id).orElseThrow(()->new AdministratorNotFound(id));
        administratorRepository.delete(administrator);
        return mapper.map(administrator,AdministratorDto.class);
    }
}
