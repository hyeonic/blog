package me.hyeonic.jpaassociation.knowledge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    @Transactional
    public Long save(Knowledge knowledge) {
        return knowledgeRepository.save(knowledge).getId();
    }

    public Knowledge findById(Long id) {
        return knowledgeRepository.findById(id).get();
    }

    public List<Knowledge> findAll() {
        return knowledgeRepository.findAll();
    }
}