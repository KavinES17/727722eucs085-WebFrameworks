package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.Language;
import com.example.day5cw3.repository.LanguageRepo;

@Service
public class LanguageService {
    private LanguageRepo languageRepo;
    public LanguageService(LanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(Language language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Language> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,Language language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public Language getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}
