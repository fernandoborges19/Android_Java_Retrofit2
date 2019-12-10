package mobile.fasam.edu.Android_Java_Retrofit2.representacao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

    @Data
    @ToString
    @Builder
    public class Comments {
        private Integer postId;
        private Integer id;
        private String name;
        private String email;
        private String body;
    }
