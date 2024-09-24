package com.harish.companyms.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<List<Company>>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company id: "+ company.getId() + " created successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany){
        boolean updateSuccess = companyService.updateCompany(updatedCompany, id);
        if (updateSuccess){
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("id doesn't match any Company",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean deleteSuccess = companyService.deleteCompanyById(id);
        if (deleteSuccess){
            return new ResponseEntity<>("Company with id: "+id+" deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("id doesn't match any company",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company!=null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCompanies(){
        boolean deleteSuccess = companyService.deleteAllCompanies();
        if (deleteSuccess) {
            return new ResponseEntity<>("All companies deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to delete companies",HttpStatus.BAD_REQUEST);
    }
}
