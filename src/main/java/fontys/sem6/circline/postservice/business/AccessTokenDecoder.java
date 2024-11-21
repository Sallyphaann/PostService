package fontys.sem6.circline.postservice.business;


import fontys.sem6.circline.postservice.domain.AccessToken;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
