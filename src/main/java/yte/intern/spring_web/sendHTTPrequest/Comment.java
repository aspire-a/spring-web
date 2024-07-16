package yte.intern.spring_web.sendHTTPrequest;

public record Comment(Long commentId,
                      Long postId,
                      String name,
                      String email,
                      String body
) {
}
