import service.BaseManagementService;
import service.impl.IBaseManagementService;

public class Main {
    public static void main(String[] args) {
        BaseManagementService baseManagementService = new IBaseManagementService();
        baseManagementService.baseManagement();
    }
}