

package com.tukin.user.mvp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}

