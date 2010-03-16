/*
 ************************************************************************************
 * Copyright (C) 2001-2009 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.core.persistence.dao;

import java.util.List;

import org.encuestame.core.persistence.dao.imp.IPoll;
import org.encuestame.core.persistence.pojo.Poll;
import org.hibernate.HibernateException;

/**
 * Poll Dao.
 * @author Morales,Diana Paola paola@encuestame.org
 * @since  March 15, 2009
 * @version $Id: $
 */

public class PollDao extends  AbstractHibernateDaoSupport implements IPoll{

     /**
     * Find All Polls.
     * @return list of all Poll
     * @throws HibernateException hibernate
     */
    public List<Poll> findAll() throws HibernateException {
        return findAll("FROM poll");}
}
