package JFace;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetection {
   public static void main(String[] args) {
     System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
     String imgfile="images/istockphoto-466385266-612x612.jpg";
     Mat src=Imgcodecs.imread(imgfile);
     String xmlfile="xml/lbpcascade_frontalface.xml";
     CascadeClassifier CC=new CascadeClassifier(xmlfile);
     MatOfRect facedetection=new MatOfRect();
     CC.detectMultiScale(src,facedetection);
     System.out.println(String.format("Detected face: %d",facedetection.toArray().length));
     
     for (Rect rect : facedetection.toArray()) {
    	 Imgproc.rectangle(src,new Point(rect.x,rect.y),new Point(rect.x +rect.width,rect.y + rect.height),new Scalar(0,0,255),3);
         }
     
     Imgcodecs.imwrite("images/istockphoto-466385266-612x612_out.jpg",src);
     System.out.println("Image detection finished");
   
  }
   }