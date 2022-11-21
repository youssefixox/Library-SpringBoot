package com.example.demo.services;

import com.example.demo.entity.Dict;
import com.example.demo.repository.DictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictServices {

    @Autowired
    private DictRepository dictRepository;

    public Dict createDict(Dict dict) {
        return dictRepository.save(dict);
    }

    public List<Dict> createDictList(List<Dict> list) {
        return dictRepository.saveAll(list);
    }

    public List<Dict> getDictList() {
        return dictRepository.findAll();
    }

    public Dict getDictById(int id) {
        return dictRepository.findById(id).orElse(null);
    }

    public Dict updateDictById(Dict dict) {
        Optional<Dict> dictFound = dictRepository.findById(dict.getId());

        if (dictFound.isPresent()) {
            Dict dictUpdate = dictFound.get();
            dictUpdate.setLangue(dict.getLangue());
            dictUpdate.setPrice(dict.getPrice());

            return dictRepository.save(dict);
        } else {
            return null;
        }
    }

    public String deleteDictById(int id) {
        dictRepository.deleteById(id);
        return "Dict "+ id +" deleted";
    }
}
