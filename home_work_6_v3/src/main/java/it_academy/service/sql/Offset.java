package it_academy.service.sql;/* created by Kaminskii Ivan
 */

public class Offset {
    public static Long getOffset(Long page,Long limit){
        if (0 < page) {
            return (page - 1L) * limit;
        }
        return page;
    }
}
