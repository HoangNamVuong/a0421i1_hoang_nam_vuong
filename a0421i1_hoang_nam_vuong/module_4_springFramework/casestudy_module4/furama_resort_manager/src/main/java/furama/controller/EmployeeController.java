package furama.controller;

import furama.model.employee.*;
import furama.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IUserService userService;

    @ModelAttribute("positionList")
    public Iterable<Position> positionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public Iterable<EducationDegree> educationDegreeList() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisionList")
    public Iterable<Division> divisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("userList")
    public Iterable<User> userList() {
        return userService.findAll();
    }

    @GetMapping
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        model.addAttribute("employeePage", employeePage);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        } else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Create successfully!");
            return "redirect:/employee";
        }
    }
    @GetMapping("delete/{id}")
    public String showDetail(@PathVariable Integer id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        model.addAttribute("employee", employee.get());
        return "employee/delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id, Model model) {
        employeeService.remove(id);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.save(employee);
        return "redirect:/employee";
    }
    @PostMapping("/search")
    public String searchByName(@RequestParam @PageableDefault(size = 5) String name,
                               Model model,
                               Pageable pageable) {
        Page< Employee > employeePage = employeeService.searchByName(name, pageable);
        model.addAttribute("employeePage", employeePage);
        return "employee/list";
    }
}
