#!/usr/bin/env python
# Usage: ./songscript.py [sampsize]

# usual imports
import os
import sys
import time
import glob
import datetime
import sqlite3
import numpy as np # get it at: http://numpy.scipy.org/
# path to the Million Song Dataset subset (uncompressed)
# CHANGE IT TO YOUR LOCAL CONFIGURATION
msd_subset_path='/home/maikel/Downloads/MillionSongSubset'
msd_subset_data_path=os.path.join(msd_subset_path,'data')
msd_subset_addf_path=os.path.join(msd_subset_path,'AdditionalFiles')
assert os.path.isdir(msd_subset_path),'wrong path' # sanity check
# path to the Million Song Dataset code
# CHANGE IT TO YOUR LOCAL CONFIGURATION
msd_code_path='/home/maikel/Downloads/MSongsDB'
assert os.path.isdir(msd_code_path),'wrong path' # sanity check
# we add some paths to python so we can import MSD code
# Ubuntu: you can change the environment variable PYTHONPATH
# in your .bashrc file so you do not have to type these lines
sys.path.append( os.path.join(msd_code_path,'PythonSrc') )

# imports specific to the MSD
import hdf5_getters as GETTERS

def apply_to_all_files(basedir,func=lambda x: x,ext='.h5',limit=float('inf')):
    """
    From a base directory, go through all subdirectories,
    find all files with the given extension, apply the
    given function 'func' to all of them.
    If no 'func' is passed, we do nothing except counting.
    INPUT
       basedir  - base directory of the dataset
       func     - function to apply to all filenames
       ext      - extension, .h5 by default
    RETURN
       number of files
    """
    cnt = 0
    l = []
    # iterate over all files in all subdirectories
    for root, dirs, files in os.walk(basedir):
        files = glob.glob(os.path.join(root,'*'+ext))
        # count files
        #cnt += len(files)
        # apply function to all files
        for f in files :
            cnt += 1
            res = func(f)
            l.append(res)
            if cnt >= limit:
                return l
    return l


filename = '/home/maikel/Downloads/MillionSongSubset/data/A/A/A/TRAAAAW128F429D538.h5'
methods=[f for f in dir(GETTERS) if f.startswith('get_')]

def retrieve_all_attributes(filename):
    h5 = GETTERS.open_h5_file_read(filename)
    d = {'filename': filename}
    for m in methods:
        f = getattr(GETTERS, m)
        d[m[4:]] = f(h5)
    #print d
    h5.close()
    return d

#l = apply_to_all_files(msd_subset_data_path,func=retrieve_all_attributes,limit=2)
#print l
try: k = int(sys.argv[1])
except IndexError: k = 10

files = apply_to_all_files(msd_subset_data_path,func=lambda x:x)
import random
l = [retrieve_all_attributes(f) for f in random.sample(files, k)]

switch = 1

if not switch:
    types = {np.int32: 'int', np.float64: 'double', np.ndarray: 'Object[]', np.string_: 'String', str: 'String', np.int64: 'long'}
    e = l[0]
    for k in sorted(e):
        print 'private %s %s;' % (types[type(e[k])], k)

import json
for e in l:
    for k in e:
        if type(e[k]) == np.ndarray:
            e[k] = e[k].tolist()
        try:
            json.dumps(e[k])
        except TypeError:
            e[k] = str(e[k])
        #typ = str(type(e[k]))
        #e[k] = {'value': val, 'type': typ}

if switch:
    print json.dumps(l)
