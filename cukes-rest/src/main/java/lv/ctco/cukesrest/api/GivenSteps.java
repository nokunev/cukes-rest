package lv.ctco.cukesrest.api;

import com.google.inject.*;
import cucumber.api.java.en.*;
import lv.ctco.cukesrest.*;
import lv.ctco.cukesrest.internal.*;
import lv.ctco.cukesrest.internal.context.*;
import lv.ctco.cukesrest.internal.resources.*;

@Singleton
public class GivenSteps {

    @Inject
    RequestSpecificationFacade facade;

    @Inject
    GlobalWorldFacade world;

    @Inject
    ResourceFileReader reader;

    @Given("^let variable \"([^\"]+)\" equal to \"([^\"]+)\"$")
    public void var_assigned(String varName, String value) {
        world.put(varName, value);
    }

    @Given("^baseUri is (.+)$")
    public void base_Uri_Is(String url) {
        facade.baseUri(url);
    }

    @Given("^resources root is (.+)$")
    public void resources_Root_Is(String url) {
        var_assigned(CukesOptions.RESOURCES_ROOT, url);
    }

    @Given("^proxy settings are (http|https)://([^:]+)(?::(\\d+))?$")
    public void proxy(String scheme, String host, Integer port) {
        facade.proxy(scheme, host, port);
    }

    @Given("^param \"(.+)\" \"(.+)\"$")
    public void param(String key, String value) {
        facade.param(key, value);
    }

    @Given("^accept \"(.+)\" mediaTypes$")
    public void accept(String mediaTypes) {
        facade.accept(mediaTypes);
    }

    @Given("^content type is \"(.+)\"$")
    public void content_Type(String contentType) {
        facade.contentType(contentType);
    }

    @Given("^queryParam \"(.+)\" is \"(.+)\"$")
    public void query_Param(String key, String value) {
        facade.queryParam(key, value);
    }

    @Given("^formParam \"(.+)\" is \"(.+)\"$")
    public void form_Param(String key, String value) {
        facade.formParam(key, value);
    }

    @Given("^request body \"(.+)\"$")
    public void request_Body(String body) {
        facade.body(body);
    }

    @Given("^request body:$")
    public void request_Body_From_Object(String body) {
        facade.body(body);
    }

    @Given("^request body from file (.+)$")
    public void request_Body_From_File(String path) {
        facade.body(reader.read(path));
    }

    @Given("^session ID \"([^\"]+)\"$")
    public void session_ID(String sessionId) {
        facade.sessionId(sessionId);
    }

    @Given("^session ID \"([^\"]+)\" with value \"([^\"]+)\"$")
    public void session_ID_With_Value(String sessionId, String value) {
        facade.sessionId(sessionId, value);
    }

    @Given("^cookie \"([^\"]+)\" with value \"([^\"]+)\"$")
    public void cookie_With_Value(String cookie, String value) {
        facade.cookie(cookie, value);
    }

    @Given("^header ([^\"]+) with value \"([^\"]+)\"$")
    public void header_With_Value(String name, String value) {
        facade.header(name, value);
    }

    @Given("^username \"([^\"]+)\" and password \"([^\"]+)\"$")
    public void authentication(String username, String password) {
        facade.authentication(username, password);
    }

    @Given("^authentication type is \"([^\"]+)\"$")
    public void authentication(String authenticationType) {
        facade.authenticationType(authenticationType);
    }
}
