import React, {useCallback} from 'react'
import {useDropzone} from 'react-dropzone'

function DropZone() {
    
    const onDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        console.log(file);
      }, [])
      const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})
    
      return (
        <div {...getRootProps()}>
          <input {...getInputProps()} />
          {
            isDragActive ?
              <p>... Drop the files here ...</p> :
              <p>Drag 'n' drop some files here, or Click to select files</p>
          }
        </div>
      )
}

export default DropZone
