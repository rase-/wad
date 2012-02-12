/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.AnnualBudget;
import wad.spring.repository.BudgetRepository;
import wad.spring.repository.TeamRepository;

/**
 *
 * @author tonykovanen
 */
@Service
public class BudgetServiceImpl implements BudgetService{
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    TeamRepository teamRepository;
    
    @Override
    @Transactional
    public void saveOrUpdate(AnnualBudget budget, Long teamId) {
        budget.setTeam(teamRepository.findOne(teamId));
        budgetRepository.save(budget);
    }

    @Override
    public List<AnnualBudget> listAll() {
        return budgetRepository.findAll();
    }
    
}
