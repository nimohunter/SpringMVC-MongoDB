package com.nimohunter.mvcdemo.MongoDB.seq.dao;

import com.nimohunter.mvcdemo.MongoDB.seq.exception.SequenceException;

/**
 * Created by nimohunter on 2017/6/14.
 * Contact me by nimohunter@gmail.com
 */


public interface SequenceDao {

    long getNextSequenceId(String key) throws SequenceException;

}
