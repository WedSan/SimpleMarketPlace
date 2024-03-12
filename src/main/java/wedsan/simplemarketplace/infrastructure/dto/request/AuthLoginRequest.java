package wedsan.simplemarketplace.infrastructure.dto.request;

public record AuthLoginRequest(
        String email,
        String password
) {
}
