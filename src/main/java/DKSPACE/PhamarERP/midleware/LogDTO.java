package DKSPACE.PhamarERP.midleware;


import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LogDTO {
    private int httpStatus;
    private String path;
    private String httpMethod;
    private String clientIp;
    private String javaMethod;
    private String arguments;
    private String response;
    private Map<String, String> headers;

}
