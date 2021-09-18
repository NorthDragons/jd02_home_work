package by.it_academy.service;/* created by Kaminskii Ivan
 */

public class HDepartmentHepler {
    private static final HDepartmentHepler instance = new HDepartmentHepler();

    public HDepartmentHepler() {
    }

    public static HDepartmentHepler getInstance() {
        return instance;
    }
}
