package wedsan.simplemarketplace.infrastructure.security;

import com.sun.source.tree.CaseTree;
import wedsan.simplemarketplace.core.domain.TokenType;

public enum TokenTypeImpl implements TokenType {
    JWT_TOKEN("JWT Token"),

    REFRESH_TOKEN("Refresh Token");

    private final String label;

    TokenTypeImpl(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
