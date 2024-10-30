# List of custom-builds

| Custom-build                  | Base library                                              | CPU                     | GPU                 | Face detection model / accuracy on [WIDER Face (Hard)](https://paperswithcode.com/sota/face-detection-on-wider-face-hard) | Face recognition model / accuracy on [LFW](https://paperswithcode.com/sota/face-verification-on-labeled-faces-in-the) | Age and gender detection                                                            | Face mask detection                              | Comment                                        |
|-------------------------------|-----------------------------------------------------------|-------------------------|---------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|--------------------------------------------------|------------------------------------------------|
| FaceNet (default)             | [FaceNet](https://github.com/davidsandberg/facenet)       | x86 (AVX instructions)  | not supported       | MTCNN / 80.9%                                                                                                             | FaceNet (20180402-114759) / 99.63%                                                                                    | Custom, the model is taken [here](https://github.com/GilLevi/AgeGenderDeepLearning) | [Custom model](../docs/Mask-detection-plugin.md) | For general purposes. Support CPU without AVX2 |
| FaceNet Masked (Experimental) | [FaceNet](https://github.com/davidsandberg/facenet)       | x86 (AVX instructions)  | not supported       | MTCNN / 80.9%                                                                                                             | inception_v3_on_mafa_kaggle123 / 98.73%                                                                               | Custom, the model is taken [here](https://github.com/GilLevi/AgeGenderDeepLearning) | [Custom model](../docs/Mask-detection-plugin.md) | For general purposes. Support CPU without AVX2 |
| Mobilenet                     | [InsightFace](https://github.com/deepinsight/insightface) | x86 (AVX2 instructions) | not supported       | RetinaFace-MobileNet0.25 / 82.5%                                                                                          | MobileFaceNet,ArcFace / 99.50%                                                                                        | InsightFace                                                                         | [Custom model](../docs/Mask-detection-plugin.md) | The fastest model among CPU only models        |
| Mobilenet-gpu                 | [InsightFace](https://github.com/deepinsight/insightface) | x86 (AVX2 instructions) | GPU (CUDA required) | RetinaFace-MobileNet0.25 / 82.5%                                                                                          | MobileFaceNet,ArcFace / 99.50%                                                                                        | InsightFace                                                                         | [Custom model](../docs/Mask-detection-plugin.md) | The fastest model                              |
| SubCenter-ArcFace-r100        | [InsightFace](https://github.com/deepinsight/insightface) | x86 (AVX2 instructions) | not supported       | retinaface_r50_v1 / 91.4%                                                                                                 | arcface-r100-msfdrop75 / 99.80%                                                                                       | InsightFace                                                                         | [Custom model](../docs/Mask-detection-plugin.md) | The most accurate model, but the most slow     |
| SubCenter-ArcFace-r100-gpu    | [InsightFace](https://github.com/deepinsight/insightface) | x86 (AVX2 instructions) | GPU (CUDA required) | retinaface_r50_v1 / 91.4%                                                                                                 | arcface-r100-msfdrop75 / 99.80%                                                                                       | InsightFace                                                                         | [Custom model](../docs/Mask-detection-plugin.md) | The most accurate model                        |