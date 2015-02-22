/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.agora.quillcity.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * An endpoint class we are exposing
 */
@Api(name = "myApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.quillcity.agora.com", ownerName = "backend.quillcity.agora.com", packagePath = ""))
public class QuillEndpoint {

    private static final String DEFAULT_LIMIT = "10";


    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod
    public QuillEntity submit(QuillEntity quill) {
        PersistenceManager pm = getPersistenceManager();
        pm.makePersistent(quill);
        pm.close();
        return quill;
    }

    @ApiMethod(name = "getPoem")
    public QuillEntity getPoem(@Named("location") Double location) {
        PersistenceManager pm = getPersistenceManager();

        Query query = pm.newQuery(QuillEntity.class);
        query.setOrdering("author desc");
        String limit = DEFAULT_LIMIT;
        query.setRange(0, new Long(limit));

        return (QuillEntity) pm.newQuery(query).execute();
    }

    private static PersistenceManager getPersistenceManager() {
        return PMF.get().getPersistenceManager();
    }
}
