package yte.intern.spring_web.sendHTTPrequest;

public record Post(Long userID,
                   Long postID,
                   String title,
                   String body
) {
}
