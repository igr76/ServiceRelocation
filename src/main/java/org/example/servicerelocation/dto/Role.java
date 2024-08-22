package org.example.servicerelocation.dto;




public enum Role //implements GrantedAuthority
{
    USER("USER"), ADMIN("ADMIN");

    private final String vale;

    Role(String vale) {
        this.vale = vale;
    }
//    @Override
//    public String getAuthority() {
//        return vale;
//    }
}
